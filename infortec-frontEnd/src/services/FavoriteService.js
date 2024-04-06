function addFavorite (data){
    return fetch ("http://localhost:8080/favorites",{
            method: "POST",
            headers: {
                "Content-type": "Application/json"
            },
            body: JSON.stringify(data)
    })

}
function verifyProductInFavoritesByClient (data){
    return fetch("http://localhost:8080/favorites",{
        method: "GET",
        headers: {
            "Content-type" : "Application/json"
        },
        body: JSON.stringify(data)
    })
}

module.exports = {
    addFavorite,
    verifyProductInFavoritesByClient
}