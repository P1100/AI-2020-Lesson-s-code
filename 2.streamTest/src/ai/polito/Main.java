package ai.polito;

import java.util.Comparator;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] words = {"Alfa", "Beta", "Gamma", "Delta"};
//        Arrays.stream(words)
        Stream.of("Alfa", "Beta", "Gamma", "Delta")
                .filter(s -> s.endsWith("ta")) //.filter(s -> s.length() > 3)
                .parallel()
                .map(s -> {
                    System.out.println(Thread.currentThread());
                    return s;
                })
                .map(String::toUpperCase) //.map(s -> s.toUpperCase())
                .forEach(System.out::println);//.forEach(s -> System.out.println(s))
        for (String s : words) {
            System.out.println(s);
        }

//        Stream.iterate(1, i -> i + 1)
        Stream.generate(() -> Math.random())
                .limit(10)
                .sorted()
                //.peek(s -> System.out.print("$"))
                .forEach(System.out::println); //not working?

        DoubleStream doubleStream = DoubleStream.of(0.457, 0.678, 0.897, 0.956);
        doubleStream.forEachOrdered(System.out::println);
        System.out.println("----------------------------------------");
        // forEachOrdered does not sort!! It's not the same
        Stream<String> stream = Stream.generate(() -> Double.toString(Math.random() * 1000)).limit(4);
        stream.sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        //.forEachOrdered(System.out::println);

        System.out.println("#########################################");
        Stream<Double> s1 = Stream
                .generate(() -> Math.random())
                .limit(10);
        Stream<Double> s2 = Stream
                .iterate(1.0, d -> d + 0.25)
                .limit(5);
        Stream.concat(s1, s2)
                .forEach(System.out::println);
        System.out.println("#########################################");

        Stream<Double> s3 = Stream
                .iterate(1.0, d -> d + 0.25)
                .limit(10);
        //System.out.println(s3.reduce(0.0, (a, b) -> a+b));
        System.out.println(s3.reduce("", (a, b) -> a + " " + b, (a, b) -> a + " " + b));
    }
    /*   ---> Pezzidi lambda usati in altri progetti!!!
    
    @GetMapping("/")
    public String home() {
        return timesStampSerice.getTimestamp() + data.stream().collect(Collectors.joining(" - "));
    }
    public List<ProductDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    }
    public List<IngredientDTO> getIngredients(String id) {
        ProductEntity p = productRepository.getOne(id);
        if (p == null)
            return null;
        else
            return p.getIngredientEntities()
                    .stream()
                    .map(i -> modelMapper.map(i, IngredientDTO.class))
                    .collect(Collectors.toList());
    }
    public List<ProductDTO> getProductsByIngredient(String ingredientId) {
        IngredientEntity ingredientEntity = ingredientRepository.getOne(ingredientId);
        if (ingredientEntity == null)
            return null;
        return productRepository.getByIngredientEntitiesContaining(ingredientEntity)
                .stream()
                .map(p -> modelMapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    */
}
