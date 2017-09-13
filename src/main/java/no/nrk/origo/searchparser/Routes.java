package no.nrk.origo.searchparser;

import io.netty.handler.codec.http.HttpMethod;

import org.restexpress.RestExpress;

public abstract class Routes {
    public static void define(Configuration config, RestExpress server) {
        //TODO: Your routes here...
        server.uri("/search/{sampleId}.{format}", config.getSearchController())
                .method(HttpMethod.GET, HttpMethod.PUT, HttpMethod.DELETE)
                .name(Constants.Routes.SINGLE_SAMPLE);

//        server.uri("/suggest", config.getSearchController())
//                .method(HttpMethod.GET, HttpMethod.POST)
//                .name(Constants.Routes.SINGLE_SAMPLE);

        server.uri("/suggest/query.{format}", config.getSearchController())
                .action("readAll", HttpMethod.GET)
                .method(HttpMethod.POST)
                .name(Constants.Routes.SEARCH_POST_ROUTE);

//		server.uri("/search/here.{format}", config.getSearchController())
//			.action("readAll", HttpMethod.GET)
//			.method(HttpMethod.POST)
//			.name(Constants.Routes.SAMPLE_COLLECTION);
// or...
//		server.regex("/some.regex", config.getRouteController());
    }
}
