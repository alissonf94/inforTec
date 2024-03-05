function addItemCart (data){
    return fetch("http://localhost:8080/shoppingCarts",{
        method: "PUT",
        headers: {
            "Content-type":"Application/json"
        },
        body: JSON.stringify(data)
    })
}

function getItemsProducts (id){
    return fetch(`http://localhost:8080/shoppingCarts/${id}`,{
        method: "GET",
        headers:{
            "Content-type":"Application/json"
        }
    })
}
module.exports = {
    addItemCart,
    getItemsProducts
}