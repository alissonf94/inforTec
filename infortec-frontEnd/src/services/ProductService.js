function findByCategory (category){
    return fetch(`http://localhost:8080/products/${category}`,{
        method: "GET",
        headers:{
            "Content-type":"Application/json"
        },
    })
}

module.exports ={
    findByCategory
}