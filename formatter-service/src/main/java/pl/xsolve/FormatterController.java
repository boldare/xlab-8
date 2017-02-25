package pl.xsolve;

import org.springframework.web.bind.annotation.*;
import pl.xsolve.dto.MessageDTO;
import pl.xsolve.dto.SnowReportDTO;

@RestController
@RequestMapping(value = "/formatters")
public class FormatterController {

    @RequestMapping(method = RequestMethod.POST, value = "/message")
    public MessageDTO format(@RequestBody SnowReportDTO report) {
        String emailMsg = buildEmailMessage(report);

        return new MessageDTO(emailMsg);
    }


    protected String buildEmailMessage(SnowReportDTO report) {
        StringBuilder msg = new StringBuilder();
        msg.append("Snow report for " + report.getReportDate() + " " + report.getResortName() + ", " + report.getResortCountry() + "\n");
        msg.append("Last snow was: " + report.getLastSnow() + "\n");
        msg.append("New snow: " + report.getNewSnowCm() + " cm" + "\n");
        msg.append("Lower snow depth: " + report.getLowerSnowDepth() + " cm \n");
        msg.append("Upper snow depth: " + report.getUpperSnowDepth() + " cm \n\n");
        msg.append("CONDITIONS: " + report.getConditions() + "\n");

        return msg.toString();
    }
}
