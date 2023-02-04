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

const Titulo = styled.Text`
  font-size: 30px;
  color: #fff;
  font-weight: 800;
`;

export {Container, Titulo};
