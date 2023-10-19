import "../styles/Resgister.css"

const register = ()=>{
    return(
        <main id="register-main">
            <form id ="formulario">
                <section>
                    <label for= "name">Nome</label>
                    <input name="name"type="text" required />
                </section>
               
                <section>
                    <label for= "email">Email</label>
                    <input name="email"type="email" required />
                </section>
               
                <section id="cpfAndBirthday">
                    <div>
                        <label for= "cpf">CPF</label>
                        <input name="cpf"type="text" required />
                    </div>
                    
                    <div>
                        <label for= "birthday">Birthday</label>
                        <input name="birthday"type="date" required />
                    </div>
                </section>
                
                <section>
                    <label for= "">Password</label>
                    <input name="password"type="password" required />
                </section>
                
                <section id="enviar">
                <input type="submit" value= "Cadastrar"/>
                </section>

                <section><p>Você já tem sua conta? <a href="/">Fazer login.</a></p></section>
            </form>
        </main>
    )
    
}

export default register