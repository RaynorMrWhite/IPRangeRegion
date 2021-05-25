package rr.tt.ww.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Ipv6_Prefix {

    private String ipv6_prefix;
    private String region;
    private String service;
    private String nerwork_border_group;

    public String getIpv6_prefix() {
        return ipv6_prefix;
    }

    public void setIpv6_prefix(String ipv6_prefix) {
        this.ipv6_prefix = ipv6_prefix;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getNerwork_border_group() {
        return nerwork_border_group;
    }

    public void setNerwork_border_group(String nerwork_border_group) {
        this.nerwork_border_group = nerwork_border_group;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
