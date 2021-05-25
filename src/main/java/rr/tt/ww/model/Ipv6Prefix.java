package rr.tt.ww.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Ipv6Prefix {

    private String ipv6_prefix;
    private String region;

    public String getIpv6_prefix() {
        return ipv6_prefix;
    }

    public void setIpv6_prefix(String ipv6_prefix) {
        this.ipv6_prefix = ipv6_prefix;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
