import "../styles/ItemPromotion.css"
const itemPromotion = (props)=>{
    return (
        <div className="item" key={props.id}>
            <div className="image">
                < img src={props.urlImage} className="image-item"></img>
            </div>

            <div className="info">
                <div className="name">
                    <span className="name-item">{props.name}</span>
                </div>
                <div className="prices">
                    <span className="old-price"> R$ {props.price}</span>
                    <span className="current-price">R$ {props.pricePromotion}</span> 
                </div>
                 
            </div>
        </div>
    )
}

export default itemPromotion