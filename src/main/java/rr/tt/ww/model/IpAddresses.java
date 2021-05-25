package rr.tt.ww.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class IpAddresses {
    private List<IpPrefix> prefixes;
    private List<Ipv6Prefix> ipv6_prefixes;

    public List<IpPrefix> getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(List<IpPrefix> ipPrefixes) {
        this.prefixes = ipPrefixes;
    }

    public List<Ipv6Prefix> getIpv6_prefixes() {
        return ipv6_prefixes;
    }

    public void setIpv6_prefixes(List<Ipv6Prefix> ipv6_prefixes) {
        this.ipv6_prefixes = ipv6_prefixes;
    }

}
