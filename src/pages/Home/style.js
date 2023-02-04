import styled from 'styled-components';
import {colors} from '../../assets/colors';

const Container = styled.ImageBackground`
  flex: 1;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 15%;
  padding-bottom: 5%;
  align-items: center;
  justify-content: space-between;
`;
const TituloEsquerda = styled.View`
  width: 100%;
  align-items: flex-start;
`;
const Titulo = styled.Text`
  font-size: 30px;
  color: #fff;
  font-weight: 800;
`;

const BtnProcurarMais = styled.TouchableOpacity`
  width: 100%;
  background-color: ${colors.fundo_btn};
  padding: 15px;
  align-items: center;
  justify-content: center;
  border-radius: 9px;
`;

const BtnProcurarMaisText = styled.Text`
  font-size: 22px;
  color: white;
  font-weight: 400;
`;

export {
  Container,
  TituloEsquerda,
  Titulo,
  BtnProcurarMais,
  BtnProcurarMaisText,
};
