function findAllPromotions (){
    return(
        fetch(
            "http://localhost:8080/promotions",
            {
                method: "GET",
                headers:{
                    "Content-type":"Application/json",
                },
            }
        )
    )
}

module.exports = {
    findAllPromotions
}