import styled from 'styled-components';
import {colors} from '../../../assets/colors';
const Container = styled.View`
  flex: 1;
  /* padding-left: 20px;
  padding-right: 20px; */
  align-items: center;
  justify-content: center;
  background-color: ${colors.fundo_feed};
  padding-top: 15%;
`;

const Header = styled.TouchableOpacity`
  width: 100%;
  align-items: center;
  justify-content: flex-start;
  flex-direction: row;
  margin-bottom: 20px;
  padding-left: 20px;
`;

const VoltarTitulo = styled.Text`
  font-size: 25px;
  color: #000;
  margin-left: 10px;
  font-weight: 800;
`;

export {Container, Header, VoltarTitulo};
