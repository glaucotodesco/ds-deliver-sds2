import { useState } from "react";

function Counter() {

    const [counter, setCounter] = useState(0);

    const handleIncrease = () => {
        setCounter(counter+1);
    }

    const handleDecrease = () => {
        setCounter(counter-1);
    }

    return (
        <div>
            <button onClick={handleIncrease}>Increase</button>
            <button onClick={handleDecrease}>Decrease</button>
            <h1>Value of counter {counter}</h1>
        </div>

    )


}

export default Counter;