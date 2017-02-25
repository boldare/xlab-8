package pl.xsolve.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import pl.xsolve.dto.MessageDTO;
import pl.xsolve.dto.SnowReportDTO;

@Component
public class FormatterManagerImpl implements FormatterManager {

    @Value("${formatter.url}")
    private String formatterUrl;

    protected RestOperations restOperations;

    @Autowired
    public FormatterManagerImpl(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @Override
    public MessageDTO format(SnowReportDTO report) {
        return restOperations.postForObject(formatterUrl, report, MessageDTO.class);
    }
}
