import "../styles/Login.css"

const login = ()=>{
    return (
    <main id="login-main">
       <section id ='imagem'> <img src={require("../imgs/Logo.png")} alt="" /></section>
        
        <section id = "form">
            <form>
                <h3>Login</h3>

                <div className="input">
                    <label  htmlFor="email">Email</label>
                    <input  name="email" type="email"  required />
                </div>

                <div  className="input">
                    <label htmlFor="password">Senha</label>
                    <input  name="password" type="password" required/>  
                </div>

                <div id= "continuar"> <button type="submit" > Continuar</button></div>
            </form>
        </section>

        <section id='criar-conta'><a href="/register">Crie sua conta na Infor Tec</a></section>
    </main>
    )
}

export default login