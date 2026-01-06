package ir.moke.groovy.dsl

class RouteConfig {
    String basePath
    List<String> gets = []
    List<String> posts = []

    RouteConfig(String basePath) {
        this.basePath = basePath
    }

    void get(String path) {
        gets << path
    }

    void post(String path) {
        posts << path
    }
}
