function updateItemProduct(data){
    return fetch("http://localhost:8080/itemProduct", {
        method: "PUT",
        headers:{
            "Content-type":"Application/json"
        },
        body: JSON.stringify(data)
    })
}

function deleteItemProduct (id){
    return fetch(`http://localhost:8080/itemProduct/${id}`,{
        method: "DELETE",
        headers:{
            "Content-type":"Application/json"
        }
    })
}
module.exports = {
    updateItemProduct,
    deleteItemProduct
}