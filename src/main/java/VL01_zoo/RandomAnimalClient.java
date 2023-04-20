package VL01_zoo;

import VL01_zoo.model.Animal;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomAnimalClient {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    RandomAnimalClient(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }


    public ResponseEntity<Animal> random() {
        System.out.println("Sending  request for animal {}");
        ResponseEntity<Animal> response = restTemplate.getForEntity("http://random-animal/random", Animal.class);
        Animal anm = response.getBody();
        System.out.println("name = " + anm.getName());
        return response;
    }

//    public ResponseEntity<Animal> random1() {
//
//        ServiceInstance instance = discoveryClient.getInstances("random-animal")
//                .stream().findAny()
//                .orElseThrow(() -> new IllegalStateException("Random-animal service unavailable"));
//
//        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
//                .fromHttpUrl(instance.getUri().toString() + "/random");
//        return restTemplate.getForEntity(uriComponentsBuilder.toUriString(), Animal.class);
//    }
}