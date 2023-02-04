import styled from 'styled-components';
import {colors} from '../assets/colors';
const Card = styled.View`
  width: 100%;
  background-color: ${colors.fundo_card};
  padding: 30px;
  border-radius: 9px;
  justify-content: center;
  align-items: center;
`;
const CardFrase = styled.Text`
  font-size: 20px;
  color: white;
  font-weight: 700;
`;
const CardCantor = styled.Text`
  font-size: 24px;
  color: white;
  font-weight: 300;
`;

export {Card, CardFrase, CardCantor};
