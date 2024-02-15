import "../styles/ItemProduct.css"

const ItemProduct = (props)=>{
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
                    <span className="current-price"> R$ {props.price}</span>
                </div>
                 
            </div>
        </div>
    )
}

export default ItemProduct