function addItemCart (data){
    return fetch("http://localhost:8080/shoppingCarts",{
        method: "PUT",
        headers: {
            "Content-type":"Application/json"
        },
        body: JSON.stringify(data)
    })
}

module.exports = {
    addItemCart
}