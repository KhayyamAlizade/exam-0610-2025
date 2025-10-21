package az.ingress;

import az.ingress.entity.Guide;
import az.ingress.mapper.GuideMapper;
import az.ingress.model.request.CreateGuideRequest;
import az.ingress.model.request.CreatePassportRequest;
import az.ingress.model.response.GuideResponse;
import az.ingress.repository.GuideRepository;
import az.ingress.service.abs.GuideService;
import az.ingress.service.impl.GuideServiceImpl;
import az.ingress.service.impl.MuThread;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {
    private final GuideService guideService ;
    private final GuideServiceImpl guideServiceImpl;
private final GuideRepository guideRepository ;
    Guide guide=new Guide();
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        guide = guideServiceImpl.getGuideById(6l);
        if(guide==null) {
            System.out.println("No such guide");
            return;
        }

  Thread thread = new Thread(() -> {


      guide.setName("Thread 1 gird");
      guideRepository.save(guide);
      try {
          Thread.sleep(5000);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  });

        Thread thread2 = new Thread(() -> {
            Guide guide = guideServiceImpl.getGuideById(6L);
//            guideResponseById22.setName("Thread2 gird");
//            guideRepository.save(guideResponseById22);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        thread.start();
        thread2.start();



    }


//      OPTIMISTIK LOCK UOPDATE YOXLANISI
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