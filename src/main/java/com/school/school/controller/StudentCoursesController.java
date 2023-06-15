package com.school.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.school.dto.StudentCourseDto;
import com.school.school.entities.StudentCoursesEntitiy;
import com.school.school.servis.StudentCoursesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j

@RequestMapping("/api/v1/school")
public class StudentCoursesController {

    private final RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    private final StudentCoursesService studentCoursesService;

    @GetMapping("/getCourses")
    public List<StudentCoursesEntitiy> getAllStudentCourses() {
        return studentCoursesService.getAllStudent();
    }

    @GetMapping("/getCourses/lesson-id/{stId}")
    public List<StudentCoursesEntitiy> getByIdStudentCourses(@PathVariable Long stId) {
        return studentCoursesService.getByIdStudentCourses(stId);
    }

    @GetMapping("/getCourses/lesson-name/{lessonName}")
    public List<StudentCoursesEntitiy> getStudentCoursesByLessonName(@PathVariable String lessonName) {
        return studentCoursesService.getStudentCoursesByLessonName(lessonName);
    }

    @GetMapping("/getCourses/lesson-time/{lessonTime}")
    public List<StudentCoursesEntitiy> getByIdStudentCoursesByLessonTime(@PathVariable Long lessonTime) {
        return studentCoursesService.getByIdStudentCoursesByLessonTime(lessonTime);
    }

    @GetMapping("/getCourses/lesson-Name/{lessonName}")
    public List<StudentCoursesEntitiy> getByIdStudentCoursesLessonName(@PathVariable String lessonName) {
        return studentCoursesService.getStudentCoursesByLessonName(lessonName);
    }

    @GetMapping("/getCourses/lessonName-Time/{lessonTime}/{lessonName}")
    public List<StudentCoursesEntitiy> getByIdStudentCoursesLessonNameLessonTime(@PathVariable Long lessonTime, @PathVariable String lessonName) {
        return studentCoursesService.getByIdStudentCoursesLessonNameLessonTime(lessonTime, lessonName);
    }

    @GetMapping("/getCourses/lessonTime/{lessonTime}")
    public List<StudentCoursesEntitiy> getStudentCoursesByLessonTİME(@PathVariable Long lessonTime) {
        return studentCoursesService.getStudentCoursesByLessonTİME(lessonTime);
    }

    @PostMapping("/postCourses")
    public StudentCoursesEntitiy createOneCourse(@RequestBody StudentCourseDto newCourseDto) {
        return studentCoursesService.createOneCourse(newCourseDto);
    }

    @DeleteMapping("deleteCourses/{studentId}")
    public StudentCoursesEntitiy deleteOneCourse(@PathVariable Long studentId) {
        studentCoursesService.deleteOneCourse(studentId);

        return null;
    }

    @PostMapping(value = "/example/uploadFile",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> uploadSingleFileExample(@RequestParam MultipartFile file) {
        log.info("Request contains, File: " + file.getOriginalFilename());
        log.warn("warning");
        log.info("information");
        log.trace("tracing");

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                String completeData = new String(bytes);

                JSONObject jsonObject = new JSONObject(completeData);


              //  System.out.println("complete data: " + completeData.toString());
                System.out.println("complete data: " + completeData.trim());

                jsonObject.get("firstName").toString();
                jsonObject.get("lastName").toString();
                jsonObject.get("mail").toString();

                String[] rows = completeData.split("#");
                System.out.println("rows: " + rows.length);
                String[] columns = rows[0].split(",");

            } catch (Exception e) {
                log.error("Exception catched in file: " + e.getMessage());
            }
        }
        return ResponseEntity.ok("Success");
    }

    @PostMapping(value = "/student/studentFile",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String uploadStudentFileExample(@RequestParam MultipartFile file) {
        log.info("Request contains, File: " + file.getOriginalFilename());
        try {
            // MultipartFile'dan InputStream al
            InputStream inputStream =file.getInputStream();

            // Workbook oluştur (XSSFWorkbook kullanıyoruz, .xlsx dosyaları için)
            Workbook workbook = new XSSFWorkbook(inputStream);

            // İlk sayfayı al
            Sheet sayfa = workbook.getSheetAt(0);

            // Tüm satırları dolaş
            for (Row satir : sayfa) {
                // Tüm hücreleri dolaş
                for (Cell hucre : satir) {
                    // Hücrenin değerini al
                    CellType hucreTipi = hucre.getCellType();
                    if (hucreTipi == CellType.STRING) {
                        System.out.print(hucre.getStringCellValue() + " ");
                    } else if (hucreTipi == CellType.NUMERIC) {
                        System.out.print(hucre.getNumericCellValue() + " ");
                    } else if (hucreTipi == CellType.BOOLEAN) {
                        System.out.print(hucre.getBooleanCellValue() + " ");
                    }
                }
                System.out.println(); // Her satır için yeni satır oluştur
            }

            // Workbook'u kapat
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
}



