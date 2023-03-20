DROP TABLE IF EXISTS `url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `url` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `register_at` timestamp DEFAULT NULL,
                            `updated_at` timestamp DEFAULT NULL,
                            'deleted_at' timestamp DEFAULT NULL,
                            `destination` varchar(2100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `newUrl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `cnt` int(11) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
