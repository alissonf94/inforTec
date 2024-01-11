import "../styles/Resgister.css"
export default function InputForm(props) {
    return (
        <div className="inputs">
            <label htmlFor={props.htmlFor}>{props.value}</label>
            <input  name={props.name} type= {props.type} required />
        </div>
    )
}