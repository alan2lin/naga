package com.alan2lin.bbs.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Suite
@SuiteDisplayName("测试套件，分组测试")
@SelectPackages({"com.alan2lin.bbs.test.tc"})
public class SuiteTests {

}
