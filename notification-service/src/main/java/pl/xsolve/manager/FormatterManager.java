package pl.xsolve.manager;

import pl.xsolve.dto.MessageDTO;
import pl.xsolve.dto.SnowReportDTO;

public interface FormatterManager {

    MessageDTO format(SnowReportDTO report);
}
