package rr.tt.ww.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rr.tt.ww.model.IpAddresses;
import rr.tt.ww.repository.JsonParsingServiceInterface;


@Service
public class JsonParsingService implements JsonParsingServiceInterface {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Object parse(String url) {
        return restTemplate.getForObject(url, IpAddresses.class);
    }

}
