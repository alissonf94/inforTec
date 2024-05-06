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
   
    return fetch(`http://localhost:8080/favorites/check?idProduct=${data.idProduct}&idClient=${data.idClient}`,{
        method: "GET",
        headers: {
            "Content-type" : "Application/json"
        },
    })
}

function deleteProductInFavorites (idProduct){
    return fetch(`http://localhost:8080/favorites/${idProduct}`,{
        method: "DELETE",
        headers:{
            "Content-type":"Application/json"
        }
    }
)
}
function deleteById(idFavorite){
    return fetch(`http://localhost:8080/favorites?idFavorite=${idFavorite}`,{
        method: "DELETE",
        headers:{
            "Content-type":"Application/json"
        }
    }
)
}
function findAll (idClient){
    return fetch(`http://localhost:8080/favorites/${idClient}`, {
        method: "GET",
        headers: {
            "content-type" : "application-json"
        }
    })
}

module.exports = {
    addFavorite,
    verifyProductInFavoritesByClient,
    deleteProductInFavorites,
    findAll,
    deleteById
}