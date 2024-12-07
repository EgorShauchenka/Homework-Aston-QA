package lesson17.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataGet {

    private Args args;
    private Headers headers;
    private String url;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Args {
        public String foo1;
        public String foo2;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Headers {
        @JsonProperty("x-forwarded-proto")
        public String xForwardedProto;
        @JsonProperty("x-forwarded-port")
        public String xForwardedPort;
        public String host;
        @JsonProperty("x-amzn-trace-id")
        public String xAmznTraceId;
        @JsonProperty("content-type")
        public String contentType;
        @JsonProperty("user-agent")
        public String userAgent;
        @JsonProperty("accept-encoding")
        public String acceptEncoding;
        public String accept;
    }
}