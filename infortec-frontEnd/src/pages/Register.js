import "../styles/Resgister.css"
import { useNavigate } from 'react-router-dom';
import { useState } from "react";
import AuthService from "../services/AuthService"

const Register = () => {
    const [password, setPassword] = useState("")
    const [cpf, setCpf] = useState("")
    const [email, setEmail] = useState("")
    const [name, setName] = useState("")
    const navigate = useNavigate()

    const handleSumit = async (event) => {
        event.preventDefault();

        const formData = new FormData(event.currentTarget)

        const data = {}


        for (const [key, value] of formData) {
            data[key] = value
        }

        data["role"]="CLIENT"
        
        try {
            const response = await AuthService.register(data);
            
            if (response.status === 200) {
                navigate("/")
            }
        }
        catch (error) {
            console.log(error.message);
        }
    }
    return (
        <main id="register-main">
            <section id='imagem'> <img src={require("../imgs/Logo.png")} alt="" /></section>
            
            <section id="form-register">
                <form onSubmit={handleSumit}>
                    <h3>Register</h3>

                    <div className="inputs">
                        <label htmlFor="name">Name:</label>
                        <input value={name} onChange={(e) => setName(e.target.value)} name="name" type="txt" required />
                    </div>

                    <div className="inputs">
                        <label htmlFor="email">Email:</label>
                        <input value={email} onChange={(e) => setEmail(e.target.value)} name="email" type="email" required />
                    </div>

                    <div  className="inputs">
                        <label htmlFor="cpf">CPF</label>
                        <input value={cpf} onChange={(e) => setCpf(e.target.value)} name="cpf" type="text" required />
                    </div>

                    <div className="inputs">
                        <label htmlFor="passsword">Passord:</label>
                        <input value={password} onChange={(e) => setPassword(e.target.value)} name="password" type="password" required />
                    </div>
                    <button id="registrar" type="submit" > Register</button>
                </form>
            </section>

        </main>
    )
}

export default Register