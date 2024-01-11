import "../styles/Login.css"
import AuthService from "../services/AuthService"
import { useNavigate } from 'react-router-dom';
import { useState } from "react";

const Login = () => {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    
    const navigate = useNavigate()

    const handleSubmit = async (event)=>{
        event.preventDefault();
        const formData = new FormData(event.currentTarget)

        const data = {}
        for (const [key, value] of formData) {
            data[key] = value
        }

        try {
            const response = await AuthService.login(data)
            
            if(response.status === 200){
               navigate("/home")
            }

        } 
        catch (error) {
             console.log(error.message);
        }
    }
    return (
        <main id="login-main">
            <section id='imagem'> <img src={require("../imgs/Logo.png")} alt="" /></section>
            <section id="form">
                <form onSubmit={handleSubmit}>
                    <h3>Login</h3>
                   
                    <div className="input">
                        <label htmlFor="email">Email:</label>
                        <input onChange={(e)=> setEmail(e.target.value)} name="email" type="email" value={email} required />
                    </div>
                    <div className="input">
                        <label htmlFor="password">Password:</label>
                        <input onChange={(e)=>setPassword(e.target.value)} name="password" type="password" value={password} required />
                    </div>

                    <div id="continuar"> <button type="submit" > Continuar</button></div>
                </form>
            </section>

            <section id='criar-conta'><a href="/register">Crie sua conta na Infor Tec</a></section>
        </main>
    )
}

export default Login