package com.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class ConfigProperties {
    @Value("${speed.manualscript}")
    private String manual_speed_script;

    public String getManualSpeedScript() {
        return manual_speed_script;
    }

    public void setManualSpeedScript(String manualSpeedScript) {
        this.manual_speed_script = manualSpeedScript;
    }
}
