import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';
import React, {useState} from "react";

function App() {

  const [btnCadastrar, setBtnCadastrar] = useState(true);

  return (
    <div>
      <Formulario botao={btnCadastrar} />
      <Tabela />
    </div>
  );
}

export default App;
