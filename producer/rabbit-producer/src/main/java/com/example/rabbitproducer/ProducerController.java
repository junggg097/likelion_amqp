package com.example.rabbitproducer;

import com.example.rabbitproducer.dto.JobRequest;
import com.example.rabbitproducer.dto.JobStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService service;

    //    @PostMapping("/make-job")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void makeJob(
//            @RequestParam("message")
//            String message
//    ) {
//        service.send(message);
//    }
    @PostMapping("/make-job")
    public JobStatus makeJob(
            @RequestBody
            JobRequest dto
    ) {
        return service.send(dto);
    }

    @GetMapping("/get-job")
    public JobStatus getJob(
            @RequestParam("job")
            String jobId
    ) {
        return service.getJobStatus(jobId);
    }
}