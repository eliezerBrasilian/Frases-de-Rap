import {useNavigation} from '@react-navigation/native';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Home from './src/pages/Home';
import Feed from './src/pages/Feed';
import CategoriasCards from './src/pages/CategoriasStack/CategoriasCards';
import CategoriaFeed from './src/pages/CategoriasStack/CategoriaFeed';
const Stack = createNativeStackNavigator();

export default App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{animation: 'slide_from_right', headerShown: false}}>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Feed" component={Feed} />
        <Stack.Screen name="CategoriasCards" component={CategoriasCards} />
        <Stack.Screen name="CategoriaFeed" component={CategoriaFeed} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};
