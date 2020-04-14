package it.polito.ai.boot1;

import org.springframework.stereotype.Service;

// @Primary //scelta di questo service piuttosto che altro conflittuale
@Service
public class TimestampFakeServiceImpl implements TimeStampService {
    @Override
    public String getTimestamp() {
        return "This is fake timestampService";
    }
}
