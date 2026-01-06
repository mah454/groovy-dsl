server {
    port 8080
    ssl true

    routes("/api") {
        get "/users"
        post "/users"
    }

    routes("/admin") {
        get "/dashboard"
    }
}