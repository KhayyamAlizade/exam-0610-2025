package az.ingress;

import az.ingress.controller.order.OrderController;
import az.ingress.model.client.request.ProductResponse;
import az.ingress.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



import static org.springframework.core.annotation.OrderUtils.getOrder;

@EnableFeignClients
@RequiredArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {
    private final OrderController orderController;
    
//    private final GuideService guideService ;
//    private final GuideServiceImpl guideServiceImpl;
private final GuideRepository guideRepository ;
//    Guide guide=new Guide();
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ProductResponse order = orderController.getOrder(1L);
        System.out.println(order);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        guide = guideServiceImpl.getGuideById(6l);
//        if(guide==null) {
//            System.out.println("No such guide");
//            return;
//        }
//        guide.setName("Thread 1 GIRDI");
//  Thread thread = new Thread(() -> {
//      try {
//          Thread.sleep(5000);
//      } catch (InterruptedException e) {
//          throw new RuntimeException(e);
//      }
//      System.out.println(LocalDateTime.now());
//      guideRepository.save(guide);
//
//
//  });
//
//        Thread thread2 = new Thread(() -> {
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            Guide guide = guideServiceImpl.getGuideById(6L);
////            guideResponseById22.setName("Thread2 gird");
////            guideRepository.save(guideResponseById22);
//
//        });
//
//
//        thread.start();
//        thread2.start();






////      OPTIMISTIK LOCK UOPDATE YOXLANISI
//        Thread thread = new Thread(() -> {
//      Guide guideResponseById11 = guideServiceImpl.getGuideById(6L);
//    guideResponseById11.setName("Thread 1 gird");
//      guideRepository.save(guideResponseById11);
//      try {
//          Thread.sleep(5000);
//      } catch (InterruptedException e) {
//          throw new RuntimeException(e);
//      }
//  });
//
//        Thread thread2 = new Thread(() -> {
//            Guide guideResponseById22 = guideServiceImpl.getGuideById(6L);
//            guideResponseById22.setName("Thread2 gird");
//            guideRepository.save(guideResponseById22);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//
//        thread.start();
//        thread2.start();
}