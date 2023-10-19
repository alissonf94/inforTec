import "../styles/Login.css"

const login = ()=>{
    return (
    <main id="login-main">
       <section id ='imagem'> <img src={require("../imgs/Logo.png")} alt="" /></section>
        
        <section id = "inputs">
            <h3>Login</h3>
            <div>
                <label id="" htmlFor="email">Email</label>
                <input  required name="email" type="email"  />
            </div>

            <div>
                <label htmlFor="password">Senha</label>
                <input required name="password" type="password"/>  
            </div>

            <button>Continuar</button>
        </section>

        <section id='criar-conta'><a href="/register">Crie sua conta na Infor Tec</a></section>
    </main>
    )
}

export default login