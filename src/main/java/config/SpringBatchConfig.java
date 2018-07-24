package config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public Job testJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                       ItemReader<String> itemReader, ItemProcessor<> processor){
        Step step = stepBuilderFactory.get("file-load")
                .chunk(100)
                .reader(itemReader)
                .processor(processor)
                .writer()
                .build();
        return jobBuilderFactory.get("test-job").incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<String> fileItemReader (@Value("${input}") Resource resource){
        FlatFileItemReader<String> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV-String-Reader");
    }
}
