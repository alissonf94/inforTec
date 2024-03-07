function updateItemProduct(data){
    return fetch("http://localhost:8080/itemProduct", {
        method: "PUT",
        headers:{
            "Content-type":"Application/json"
        },
        body: JSON.stringify(data)
    })
}

module.exports = {
    updateItemProduct
}