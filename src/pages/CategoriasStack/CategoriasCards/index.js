import {Button, Card} from './style';
export default CategoriasCard = ({dado}) => {
  return (
    <Button>
      <Card source={{uri: dado.foto}} />
    </Button>
  );
};
