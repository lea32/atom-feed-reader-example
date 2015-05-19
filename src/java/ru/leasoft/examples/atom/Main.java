package ru.leasoft.examples.atom;

import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;
import org.springframework.http.converter.feed.AtomFeedHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Main {

    static final String EXAMPLE_URL = "http://use.perl.org/index.atom";

    public static void main(String[] args) {
        String url = (args.length > 0) ? args[0] : EXAMPLE_URL;

        AtomFeedHttpMessageConverter converter = new AtomFeedHttpMessageConverter();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(converter);

        Feed feed = restTemplate.getForObject(url, Feed.class);

        System.out.println(feed.getTitle());
        System.out.println(feed.getCopyright());
        System.out.println("----------------------");

        for (Entry entry: feed.getEntries()) {
            System.out.println(entry.getTitle());
        }

    }

}
