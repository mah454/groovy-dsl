package ir.moke.groovy.dsl

class ServerConfig {
    int port
    boolean ssl
    List<RouteConfig> routes = []

    void port(int port) {
        this.port = port
    }

    void ssl(boolean ssl) {
        this.ssl = ssl
    }

    void routes(String path,Closure c) {
        def rc = new RouteConfig(path)
        c.delegate = rc
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c()
        routes << rc
    }
}
