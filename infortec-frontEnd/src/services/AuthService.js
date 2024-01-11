function login(data)
{
    return fetch("http://localhost:8080/auth/login",{
        method: "POST",
        headers:{
            "Content-type":"Application/json",
        },
        body: JSON.stringify(data)
    })
}

function register(data){
    return fetch("http://localhost:8080/auth/register",{
        method: "POST",
        headers:{
            "Content-type":"Application/json",
        },
        body: JSON.stringify(data)
    })
}

module.exports = {
    login,
    register
}