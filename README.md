# Answer

### API includes services:

1. **HTTP POST**: */customers/sort-by-due-time* 

     Takes list of customer and sort them by due time ASC. 
     

### Test
#### Automatically
     There are 2 scope of tests: 
        1. Unit Test
        2. Integration Test
        
     I did not write different profile to run them seperately because it is toy project.
     To simply test the application run following command:
        
        - mvn clean install            
 
 
#### Manually from UI

    To test application manually go to following page and upload data and see the result.
    
        - http://localhost:8080/swagger-ui.html
        
        
### Architecture

I followed hexagonal ( Ports & Adapters ) architecture: https://blog.ndepend.com/hexagonal-architecture/
We have 3 layer: 
1. Infrastructure: Outmost layer for third party and tech dependencies here.
2. Application: This layer has services for glue between domain and infrastructure layer (Won't need it)
3. Domain: Your domain-core layer here. Business most information. 