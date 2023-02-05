import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';

import CategoriasCards from './CategoriasCards';
import CategoriaFeed from './CategoriaFeed';
export default CategoriasStack = () => {
  const Stack = createNativeStackNavigator();
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="CategoriasCards" component={CategoriasCards} />
        <Stack.Screen name="CategoriaFeed" component={CategoriaFeed} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};
