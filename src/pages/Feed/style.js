import styled from 'styled-components';
import {colors} from '../../assets/colors';

const Container = styled.View`
  flex: 1;
  align-items: center;
  padding-top: 15%;
  padding-bottom: 10px;
  background-color: ${colors.fundo_feed};
`;
const TituloEsquerda = styled.View`
  padding-left: 20px;
  width: 100%;
  align-items: flex-start;
`;
const Titulo = styled.Text`
  font-size: 27px;
  color: #000;
  font-weight: 400;
  margin-bottom: 20px;
`;

const Categorias = styled.View`
  width: 100%;
  align-items: center;
  justify-content: center;
  margin-bottom: 15px;
`;

const CategoriasTitulo = styled.Text`
  font-size: 24px;
  color: #000;
  font-weight: bold;
  margin-bottom: 10px;
`;

export {Container, TituloEsquerda, Titulo, Categorias, CategoriasTitulo};
