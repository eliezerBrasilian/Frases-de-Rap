import {Button, Card} from './style';
import React from 'react';
import {useNavigation} from '@react-navigation/native';
export default CategoriasCard = ({dado}) => {
  const nav = useNavigation();
  function goToCategoriaFeed() {
    nav.navigate('CategoriaFeed', {
      nome_key: dado.key,
    });
  }
  return (
    <Button onPress={goToCategoriaFeed}>
      <Card source={{uri: dado.foto}} />
    </Button>
  );
};
