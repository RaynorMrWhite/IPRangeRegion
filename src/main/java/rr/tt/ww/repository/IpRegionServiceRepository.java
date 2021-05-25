package rr.tt.ww.repository;

import rr.tt.ww.model.IpAddresses;

public interface IpRegionServiceRepository  {
    IpAddresses findbyregion(String region, IpAddresses ipRange);
}
